package com.puffpdx.api.service.external;

import com.puffpdx.api.model.strains.Effects;
import com.puffpdx.api.model.strains.Flowers;
import com.puffpdx.api.model.strains.Strains;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by chris.anatalio on 12/4/16.
 */
public interface CannabisReportsService {

    ResponseEntity<Strains> getStrains(String sort, String page);

    Effects getEffectsByUcpc(String ucpc);

    Flowers getFlowers(String sort, String page);
}
