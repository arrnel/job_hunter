package com.jobhunter.service.external;

import com.jobhunter.config.Config;
import com.jobhunter.dto.currency.CurrencyResponse;
import com.jobhunter.exception.InvalidRequestParamException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.jobhunter.enums.ECode.INVALID_REQUEST_PARAM;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private static final Integer port = Config.Port.currency();
    private final WebClient webClient;

    public CurrencyResponse getRate(String from, String to) {

        String url = String.format("http://localhost:%s/api/v1/currency?from=%s&to=%s", port, from, to);
        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError
                        , response -> Mono.error(new InvalidRequestParamException(
                                INVALID_REQUEST_PARAM
                                , "Check correctness of the currencies from = [" + from + "], to = [" + to + "]"))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError
                        , response -> Mono.error(new InvalidRequestParamException(
                                INVALID_REQUEST_PARAM
                                , "Unknown error of currency service"))
                )
                .bodyToFlux(CurrencyResponse.class)
                .blockFirst();
    }

}
