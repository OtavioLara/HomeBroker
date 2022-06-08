package com.inter.investing;

import org.springframework.stereotype.Service;

@Service
public record ShareService (SharesAPI sharesAPI){

    public Share findShareBySymbol(String symbol){
        return sharesAPI.findCompanyBySymbol(symbol);
    }
}
