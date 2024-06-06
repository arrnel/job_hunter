package com.jobhunter.dataParser.parser.impl;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.jobhunter.dataParser.parser.impl.ResourceFileCategoryParser.CategoryType.INDUSTRY;
import static com.jobhunter.dataParser.parser.impl.ResourceFileCategoryParser.CategoryType.SPECIALIZATION;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceFileCategoryParser implements FileParser {

    private final IndustryRepository industryRepository;
    private final IndustrySubRepository industrySubRepository;
    private final SpecializationRepository specializationRepository;
    private final SpecializationSubRepository specializationSubRepository;
    private final ObjectMapper om;

//    @Override
//    @SneakyThrows
//    public void parse(File file) {
//
//        JsonNode rootNode = om.readTree(file),
//                industryNode = rootNode.at("/" + INDUSTRY.getType()),
//                specializationNode = rootNode.at("/" + SPECIALIZATION.getType());
//
//        Map<String, List<String>> industriesMap = om.convertValue(industryNode, new TypeReference<>() {});
//        Map<String, List<String>> specializationsMap = om.convertValue(specializationNode, new TypeReference<>() {});
//
//        List<IndustryCategoryModel> industriesCategories = industryRepository.saveAll(
//                industriesMap.keySet().stream()
//                        .map(name -> IndustryCategoryModel.builder().name(name).build()).collect(Collectors.toSet()));
//
//        log.info("Industries categories successfully saved. Saved industries = {}", industriesCategories);
//
//        List<SpecializationCategoryModel> specializationsCategories = specializationRepository.saveAll(
//                specializationsMap.keySet().stream()
//                        .map(name -> SpecializationCategoryModel.builder().name(name).build()).collect(Collectors.toSet()));
//
//        log.info("Specializations categories successfully saved. Saved specializations = {}", specializationsCategories);
//
//        for (IndustryCategoryModel industry : industriesCategories)
//            industrySubRepository.saveAll(
//                    industriesMap.get(industry.getName())
//                            .stream()
//                            .map(name -> IndustrySubCategoryModel.builder().name(name).category(industry).build())
//                            .toList());
//
//        for (SpecializationCategoryModel specialization : specializationsCategories)
//            specializationSubRepository.saveAll(
//                    specializationsMap.get(specialization.getName())
//                            .stream()
//                            .map(name -> SpecializationSubCategoryModel.builder().name(name).category(specialization).build())
//                            .toList());
//    }

    @Override
    @SneakyThrows
    public void parse(File file) {

        JsonNode rootNode = om.readTree(file),
                industryNode = rootNode.at("/" + INDUSTRY.getType()),
                specializationNode = rootNode.at("/" + SPECIALIZATION.getType());

        List<IndustryCategoryModel> industriesCategories = new ArrayList<>();
        List<SpecializationCategoryModel> specializationsCategories = new ArrayList<>();

        industryNode.forEach(industry -> {
            IndustryCategoryModel industryCategory = industryRepository.findByName(industry.get("name").asText())
                    .orElse(IndustryCategoryModel.builder()
                            .id(industry.get("id").asInt())
                            .name(industry.get("name").asText())
                            .build());
            industriesCategories.add(industryCategory);

            List<IndustrySubCategoryModel> subcategories = new ArrayList<>();
            industry.get("subcategories").forEach(subcategory -> {
                IndustrySubCategoryModel subCategoryModel = industrySubRepository.findByName(subcategory.get("name").asText())
                        .orElse(IndustrySubCategoryModel.builder()
                                .id(subcategory.get("id").asInt())
                                .name(subcategory.get("name").asText())
                                .category(industryCategory)
                                .build());
                subcategories.add(subCategoryModel);
            });
            industrySubRepository.saveAll(subcategories);
        });

        industryRepository.saveAll(industriesCategories);
        log.info("Industries categories successfully saved. Saved industries = {}", industriesCategories);

        specializationNode.forEach(specialization -> {
            SpecializationCategoryModel specializationCategory = specializationRepository.findByName(specialization.get("name").asText())
                    .orElse(SpecializationCategoryModel.builder()
                            .id(specialization.get("id").asInt())
                            .name(specialization.get("name").asText())
                            .build());
            specializationsCategories.add(specializationCategory);

            List<SpecializationSubCategoryModel> subcategories = new ArrayList<>();
            specialization.get("subcategories").forEach(subcategory -> {
                SpecializationSubCategoryModel subCategoryModel = specializationSubRepository.findByName(subcategory.get("name").asText())
                        .orElse(SpecializationSubCategoryModel.builder()
                                .id(subcategory.get("id").asInt())
                                .name(subcategory.get("name").asText())
                                .category(specializationCategory)
                                .build());
                subcategories.add(subCategoryModel);
            });
            specializationSubRepository.saveAll(subcategories);
        });

        specializationRepository.saveAll(specializationsCategories);
        log.info("Specializations categories successfully saved. Saved specializations = {}", specializationsCategories);
    }

    @Getter
    @RequiredArgsConstructor
    enum CategoryType {

        INDUSTRY("industries"), SPECIALIZATION("specializations");

        private final String type;

    }

}
