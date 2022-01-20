package com.example.wallet.mapper;

import com.example.wallet.dto.BalanceDto;
import com.example.wallet.model.UserBalance;
import com.example.wallet.model.WalletTransaction;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceDto toDto(UserBalance balance);

    BalanceDto toBalanceDto(WalletTransaction user);

    UserBalance toEntity(BalanceDto balanceDto);
}
