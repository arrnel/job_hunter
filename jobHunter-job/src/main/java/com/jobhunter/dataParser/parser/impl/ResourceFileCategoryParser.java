package com.jobhunter.dataParser.parser.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobhunter.dataParser.parser.FileParser;
import com.jobhunter.model.IndustryCategoryModel;
import com.jobhunter.model.IndustrySubCategoryModel;
import com.jobhunter.model.SpecializationCategoryModel;
import com.jobhunter.model.SpecializationSubCategoryModel;
import com.jobhunter.repository.IndustryRepository;
import com.jobhunter.repository.IndustrySubRepository;
import com.jobhunter.repository.SpecializationRepository;
import com.jobhunter.repository.SpecializationSubRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.jobhunter.dataParser.parser.impl.ResourceFileCategoryParser.CategoryType.INDUSTRY;
import static com.jobhunter.dataParser.parser.impl.ResourceFileCategoryParser.CategoryType.SPECIALIZATION;

@Service
@RequiredArgsConstructor
public class ResourceFileCategoryParser implements FileParser {

    private final IndustryRepository industryRepository;
    private final IndustrySubRepository industrySubRepository;
    private final SpecializationRepository specializationRepository;
    private final SpecializationSubRepository specializationSubRepository;
    private final ObjectMapper om;

    @Override
    @SneakyThrows
    public void parse(File file) {

        JsonNode rootNode = om.readTree(file),
                industryNode = rootNode.at("/" + INDUSTRY.getType()),
                specializationNode = rootNode.at("/" + SPECIALIZATION.getType());

        Map<String, List<String>> industriesMap = om.convertValue(industryNode, new TypeReference<>() {});
        Map<String, List<String>> specializationsMap = om.convertValue(specializationNode, new TypeReference<>() {});

        List<IndustryCategoryModel> industriesCategories = industryRepository.saveAll(
                industriesMap.keySet().stream()
                        .map(name -> IndustryCategoryModel.builder().name(name).build()).collect(Collectors.toSet()));

        List<SpecializationCategoryModel> specializationsCategories = specializationRepository.saveAll(
                specializationsMap.keySet().stream()
                        .map(name -> SpecializationCategoryModel.builder().name(name).build()).collect(Collectors.toSet()));

        for (IndustryCategoryModel industry : industriesCategories)
            industrySubRepository.saveAll(
                    industriesMap.get(industry.getName())
                            .stream()
                            .map(name -> IndustrySubCategoryModel.builder().name(name).category(industry).build())
                            .toList());

        for (SpecializationCategoryModel specialization : specializationsCategories)
            specializationSubRepository.saveAll(
                    specializationsMap.get(specialization.getName())
                            .stream()
                            .map(name -> SpecializationSubCategoryModel.builder().name(name).category(specialization).build())
                            .toList());
    }

    @Getter
    @RequiredArgsConstructor
    enum CategoryType {

        INDUSTRY("industries"), SPECIALIZATION("specializations");

        private final String type;

    }

}
