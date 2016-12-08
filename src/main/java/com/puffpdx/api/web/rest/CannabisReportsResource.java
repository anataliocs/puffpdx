package com.puffpdx.api.web.rest;

import com.puffpdx.api.model.strains.Effects;
import com.puffpdx.api.model.strains.Strains;
import com.puffpdx.api.service.external.CannabisReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cannabisreports")
public class CannabisReportsResource {

    @Autowired
    CannabisReportsService cannabisReportsService;

    @GetMapping("/strains")
    public ResponseEntity<Strains> activateAccount(@RequestParam(value = "sort") String sort,
                                                   @RequestParam(value = "page") String page) {
        return new ResponseEntity<Strains>(cannabisReportsService.getStrains("", ""), HttpStatus.OK);
    }

    @GetMapping("/strains/{ucpc}/effectsFlavors")
    public ResponseEntity<Effects> getEffectsByUcPc(@PathVariable(value = "ucpc") String ucpc) {
        return new ResponseEntity<Effects>(cannabisReportsService.getEffectsByUcpc(ucpc), HttpStatus.OK);
    }
}
