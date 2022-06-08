package com.inter.investing;

import org.springframework.stereotype.Service;

@Service
public record ShareTransactionService(
        ShareRepository shareRepository) {
    public Boolean addShareToWallet(Share share){
        return true;
    }
}
