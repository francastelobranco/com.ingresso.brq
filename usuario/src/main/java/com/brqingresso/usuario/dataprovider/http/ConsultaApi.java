package com.brqingresso.usuario.dataprovider.http;

import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ConsultaCep", url = "https://viacep.com.br/ws")
public interface ConsultaApi {

    @GetMapping(value = "/{cep}/json/")
    EnderecoViaCep consultaCep(@PathVariable("cep") String cep);
}