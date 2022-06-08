package com.inter.investing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/wallet")
public record ShareController (ShareService shareService) {

    @GetMapping("/{symbol}")
    public Share getShareBySymbol(@PathVariable String symbol){
        return shareService.findShareBySymbol(symbol);
    }
}
