package team.etop.xunfang.common.change;

import team.etop.xunfang.estate.dto.EstateDto;
import team.etop.xunfang.modules.po.Estate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2017/9/5.
 */
public class ChangeType {

    public EstateDto change(Estate estate) throws Exception{
        EstateDto estateDto=new EstateDto();
        estateDto.setId(estate.getId());
        estateDto.setStatus(estate.getStatus());
        estateDto.setVisitTimes(estate.getVisitTimes());
        estateDto.setMinPrice(estate.getMinPrice());
        estateDto.setMaxPrice(estate.getMaxPrice());
        estateDto.setDeveloperQuotes(estate.getDeveloperQuotes());
        estateDto.setLocation(estate.getLocation());
        estateDto.setType(estate.getType());
        estateDto.setFeature(estate.getFeature());
        estateDto.setEstateName(estate.getEstateName());
        estateDto.setEstateAddress(estate.getEstateAddress());
        estateDto.setProperty(estate.getProperty());
        estateDto.setDeveloper(estate.getDeveloper());
        estateDto.setSaleStatus(estate.getSaleStatus());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        estateDto.setFirstDelivery(simpleDateFormat.format(estate.getFirstDelivery()));
        estateDto.setLatestOpening(simpleDateFormat.format(estate.getLatestOpening()));
        estateDto.setPropertyRights(estate.getPropertyRights());
        estateDto.setTakeTime(simpleDateFormat.format(estate.getTakeTime()));
        estateDto.setHouseType(estate.getHouseType());
        estateDto.setCompany(estate.getCompany());
        estateDto.setPropertyCost(estate.getPropertyCost());
        estateDto.setPowerType(estate.getPowerType());
        estateDto.setGreenRate(estate.getGreenRate());
        estateDto.setParkingSpaces(estate.getParkingSpaces());
        estateDto.setDecoration(estate.getDecoration());
        estateDto.setEstateInformation(estate.getEstateInformation());
        estateDto.setCreateTime(estate.getCreateTime());
        estateDto.setPlotRatio(estate.getPlotRatio());
        estateDto.setArea(estate.getArea());
        estateDto.setEffectivePhotos(estate.getEffectivePhotos());
        estateDto.setPrototypeRoom(estate.getPrototypeRoom());
        estateDto.setSamplePlate(estate.getSamplePlate());
        estateDto.setLiveAction(estate.getLiveAction());
        estateDto.setFeature(estate.getFeature());
        estateDto.setTurnover(estate.getTurnover());
        estateDto.setSign(estate.getSign());
        estateDto.setUpdateTime(estateDto.getUpdateTime());
        estateDto.setSamplePlate(estate.getSamplePlate());
        estateDto.setLiveAction(estate.getLiveAction());
        estateDto.setPrototypeRoom(estate.getPrototypeRoom());
        estateDto.setEffectivePhotos(estate.getEffectivePhotos());
        return estateDto;
    }

    public Estate change(EstateDto estateDto) throws Exception{
        Date date=new Date();
        long times=date.getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d=format.format(times);
        date=format.parse(d);
        Estate estate=new Estate();
        estate.setId(estateDto.getId());
        estate.setStatus(estateDto.getStatus());
        estate.setVisitTimes(estateDto.getVisitTimes());
        estate.setMinPrice(estateDto.getMinPrice());
        estate.setMaxPrice(estateDto.getMaxPrice());
        estate.setDeveloperQuotes(estateDto.getDeveloperQuotes());
        estate.setLocation(estateDto.getLocation());
        estate.setType(estateDto.getType());
        estate.setHouseType(estateDto.getHouseType());
        estate.setFeature(estateDto.getFeature());
        estate.setEstateName(estateDto.getEstateName());
        estate.setEstateAddress(estateDto.getEstateAddress());
        estate.setProperty(estateDto.getProperty());
        estate.setDeveloper(estateDto.getDeveloper());
        estate.setSaleStatus(estateDto.getSaleStatus());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        estate.setFirstDelivery(simpleDateFormat.parse(estateDto.getFirstDelivery()));
        estate.setLatestOpening(simpleDateFormat.parse(estateDto.getLatestOpening()));
        estate.setPropertyRights(estateDto.getPropertyRights());
        estate.setTakeTime(simpleDateFormat.parse(estateDto.getTakeTime()));
        estate.setCompany(estateDto.getCompany());
        estate.setPropertyCost(estateDto.getPropertyCost());
        estate.setPowerType(estateDto.getPowerType());
        estate.setGreenRate(estateDto.getGreenRate());
        estate.setParkingSpaces(estateDto.getParkingSpaces());
        estate.setDecoration(estateDto.getDecoration());
        estate.setEstateInformation(estateDto.getEstateInformation());
        estate.setCreateTime(date);
        estate.setPlotRatio(estateDto.getPlotRatio());
        estate.setArea(estateDto.getArea());
        estate.setFeature(estateDto.getFeature());
        estate.setSign(estateDto.getSign());
        estate.setUpdateTime(estateDto.getUpdateTime());
        estate.setEffectivePhotos(estateDto.getEffectivePhotos());
        estate.setLiveAction(estateDto.getLiveAction());
        estate.setSamplePlate(estateDto.getSamplePlate());
        estate.setPrototypeRoom(estateDto.getPrototypeRoom());
        return estate;
    }
}
