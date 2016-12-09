package com.puffpdx.api.service.external;

import com.puffpdx.api.model.strains.Effects;
import com.puffpdx.api.model.strains.Flowers;
import com.puffpdx.api.model.strains.Strains;

/**
 * Created by chris.anatalio on 12/4/16.
 */
public interface CannabisReportsService {

    Strains getStrains(String sort, String page);

    Effects getEffectsByUcpc(String ucpc);

    Flowers getFlowers(String sort, String page);
}
