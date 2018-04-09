package com.tw.imageaudit.sor.infrastructure;

import com.tw.imageaudit.sor.domain.Image;
import com.tw.imageaudit.sor.domain.ImageRepo;
import org.springframework.stereotype.Component;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
@Component
public class ImageRepoImpl implements ImageRepo {
    @Override
    public Image save(Image image) {
        return image;
    }
}
