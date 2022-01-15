package com.example.wallet.mapper;

import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    List<UserInfo> toEntityList(List<UserInfo> userInfos);

    List<UserInfoDto> toDtoList(List<UserInfo> userInfo);

    UserInfoDto toDto(UserInfo userInfo);

    UserInfo toEntity(UserInfoDto userInfoDtos);

    void update(@MappingTarget UserInfo userInfo, UserInfoDto updatedInfo);



}

