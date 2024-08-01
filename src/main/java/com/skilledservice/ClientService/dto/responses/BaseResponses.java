package com.skilledservice.ClientService.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponses<T>{
    private boolean status;
    private T data;
    private int code;

}
