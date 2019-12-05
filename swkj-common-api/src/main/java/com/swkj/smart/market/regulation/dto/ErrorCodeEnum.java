package com.swkj.smart.market.regulation.dto;


/**
 * @author 81509
 */

public enum ErrorCodeEnum {
   SUCCESS(200),
   NOT_CERTIFIED(401),
   PERMISSION_DENIED(403),
   NO_RESOURCES(404),
   SERVER_ERROR(500);
   private Integer code;

   ErrorCodeEnum(int code) {
   }
}
