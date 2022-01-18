package com.example.wallet.mapper;


import com.example.wallet.dto.UserInfoDto;
import com.example.wallet.dto.WalletTransactionDto;
import com.example.wallet.model.UserInfo;
import com.example.wallet.model.WalletTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    List<WalletTransactionDto> toDtoList(List<WalletTransaction> transactions);

    WalletTransactionDto toDto(WalletTransaction transactions);

    WalletTransaction toEntity(WalletTransactionDto transactionDto);

    void update(@MappingTarget WalletTransaction transactions, WalletTransactionDto transactionDto);
}
