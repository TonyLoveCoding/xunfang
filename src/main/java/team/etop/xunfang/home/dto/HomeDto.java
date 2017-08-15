package team.etop.xunfang.home.dto;

import team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto;
import team.etop.xunfang.modules.po.Estate;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/15 18:49
 */
public class HomeDto {
    List<CarouselPhotosDto> CarouselPhotosDto;
    List<NewestEstateDto> newestEstateDto;
    List<Estate> estates;//或者新的DTO

    public List<team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto> getCarouselPhotosDto() {
        return CarouselPhotosDto;
    }

    public void setCarouselPhotosDto(List<team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto> carouselPhotosDto) {
        CarouselPhotosDto = carouselPhotosDto;
    }

    public List<NewestEstateDto> getNewestEstateDto() {
        return newestEstateDto;
    }

    public void setNewestEstateDto(List<NewestEstateDto> newestEstateDto) {
        this.newestEstateDto = newestEstateDto;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}
