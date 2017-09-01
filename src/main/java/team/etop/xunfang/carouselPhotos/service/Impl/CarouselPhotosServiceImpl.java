package team.etop.xunfang.carouselPhotos.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto;
import team.etop.xunfang.carouselPhotos.mapper.CarouselPhotosMapper;
import team.etop.xunfang.carouselPhotos.service.CarouselPhotosService;
import team.etop.xunfang.modules.po.CarouselPhotos;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asus on 2017/8/9.
 */
@Service
public class CarouselPhotosServiceImpl extends ServiceImpl<CarouselPhotosMapper, CarouselPhotosDto> implements CarouselPhotosService {
}
