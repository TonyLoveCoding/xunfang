package team.etop.xunfang.common.change;

import team.etop.xunfang.common.modifyTime.ModifyTime;
import team.etop.xunfang.estate.dto.EstateDto;
import team.etop.xunfang.modules.po.Estate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        String location=estate.getLocation();
        if(location.contains("none")){
            location=location.replace("none","不限");
        }
        estateDto.setLocation(location);
        String type=estate.getType();
        if(type.contains("none")){
            type=type.replace("none","不限");
        }
        estateDto.setType(type);
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
        String str=estate.getHouseType();
        if(str.contains("none")){
            str=str.replace("none","不限");
        }else{
            if(str.contains("1")){
                str=str.replace("1","一居");
            }
            if(str.contains("2")){
                str=str.replace("2","二居");
            }
            if(str.contains("3")){
                str=str.replace("3","三居");
            }
            if(str.contains("4")){
                str=str.replace("4","四居");
            }
            if(str.contains("5")){
                str=str.replace("5","五居及以上");
            }
        }
        estateDto.setHouseType(str);
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
        String string=estate.getFeature();
        if(string.contains("none")){
            string=string.replace("none","不限");
        }else {
            if(string.contains("1")){
                string=string.replace("1","品牌地产");
            }
            if(string.contains("2")){
                string=string.replace("2","自由购");
            }
            if(string.contains("3")){
                string=string.replace("3","现房");
            }
            if(string.contains("4")){
                string=string.replace("4","精装修");
            }
            if(string.contains("5")){
                string=string.replace("5","临地铁");
            }
            if(string.contains("6")){
                string=string.replace("6","小户型");
            }
        }
        estateDto.setFeature(string);
        estateDto.setTurnover(estate.getTurnover());
        estateDto.setSign(estate.getSign());
        estateDto.setUpdateTime(estateDto.getUpdateTime());
        estateDto.setSamplePlate(estate.getSamplePlate());
        estateDto.setLiveAction(estate.getLiveAction());
        estateDto.setPrototypeRoom(estate.getPrototypeRoom());
        estateDto.setEffectivePhotos(estate.getEffectivePhotos());
        return estateDto;
    }

    public Estate Add_Change(EstateDto estateDto) throws Exception{
        Estate estate=change(estateDto);
        Date date=new Date();
        long times=date.getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        times=(times + 8 * 60 * 60 * 1000);
        String d=format.format(times);
        date=format.parse(d);
        estate.setCreateTime(date);
        return estate;
    }

    public Estate change(EstateDto estateDto) throws Exception{
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
        estate.setFirstDelivery(new ModifyTime().modify(estateDto.getFirstDelivery()));
        estate.setLatestOpening(new ModifyTime().modify(estateDto.getLatestOpening()));
        estate.setPropertyRights(estateDto.getPropertyRights());
        estate.setTakeTime(new ModifyTime().modify(estateDto.getTakeTime()));
        estate.setCompany(estateDto.getCompany());
        estate.setPropertyCost(estateDto.getPropertyCost());
        estate.setPowerType(estateDto.getPowerType());
        estate.setGreenRate(estateDto.getGreenRate());
        estate.setParkingSpaces(estateDto.getParkingSpaces());
        estate.setDecoration(estateDto.getDecoration());
        estate.setEstateInformation(estateDto.getEstateInformation());
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
