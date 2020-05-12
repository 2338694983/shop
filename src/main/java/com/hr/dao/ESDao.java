package com.hr.dao;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.eb_shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 15:18
 **/
@Repository
public interface ESDao {
    @Select("select * from EASYBUY_SHOP where es_EU_USER_ID=#{id} and ES_VALID=1 order by es_id desc")
    @Results({
            @Result( id = true,property ="es_id",column = "es_id"),
            @Result(property ="es_ep_file_name" ,column = "es_ep_file_name"),
            @Result(property ="es_ep_name",column = "es_ep_name" ),
            @Result(property ="es_ep_price" ,column = "es_ep_price"),
            @Result(property ="es_eod_quantity",column = "es_eod_quantity" ),
            @Result(property ="es_ep_stock" ,column = "es_ep_stock"),
            @Result(property ="es_ep_id",column = "es_ep_id" ),
            @Result(property ="es_EU_USER_ID",column = "es_eu_user_id" ),
            @Result(property ="ea_valid",column = "es_valid" )
    })
    ArrayList<eb_shop> getShop(String id);

    @Update("update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity+1 where es_id=#{id}")
    int updateJia(int id);

    @Update("update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity-1 where es_id=#{id}")
    int updateJian(int id);

    @Update("update EASYBUY_SHOP set es_eod_quantity=#{es_eod_quantity} where es_id=#{es_id}")
    int updateClose(eb_shop es);

    @Update("update EASYBUY_SHOP set es_vaild=2 where es_id=#{id}")
    int getDelete(int id);

    @Insert("insert into EASYBUY_ORDER values(null,#{id},#{name},#{address},now(),#{price},1,1)")
    int insertDD(@Param("id") String id,@Param("name") String name, @Param("address") String address, @Param("price") int price);

    @Select("select EO_ID from easybuy_order order by EO_ID desc limit 0,1")
    int getSequenceId();

    @Insert("insert into EASYBUY_ORDER_DETAIL values(null,#{EO_ID},#{EP_ID},#{EOD_QUANTITY},#{EOD_COST})")
    int eodInsert(EASYBUY_ORDER_DETAIL eod);

    @Update("update  EASYBUY_SHOP set es_valid=2 where es_id=#{id}")
    int esdelete(int id);

    @Update("update EASYBUY_PRODUCT set ep_stock=ep_stock-#{stock} where ep_id=#{id}")
    int updateStock(@Param("stock") int stock,@Param("id") int id);

    @Select("SELECT EP_STOCK FROM EASYBUY_PRODUCT WHERE ep_id=#{id}")
    int findByStock(int id);

    @Insert("insert into EASYBUY_SHOP values(null,#{es_ep_file_name},#{es_ep_name},#{es_ep_price},#{es_eod_quantity},#{es_ep_stock},#{es_ep_id},#{es_EU_USER_ID},1)")
    int insert(eb_shop sp);

    @Delete("delete from  EASYBUY_SHOP where es_id=#{id}")
    int getDeleteDD(int id);

    @Select("select * from  EASYBUY_SHOP where es_eu_user_id=#{es_eu_user_id} and es_ep_id=#{pid} and es_valid = 1")
    @Results({
            @Result( id = true,property ="es_id",column = "es_id"),
            @Result(property ="es_ep_file_name" ,column = "es_ep_file_name"),
            @Result(property ="es_ep_name",column = "es_ep_name" ),
            @Result(property ="es_ep_price" ,column = "es_ep_price"),
            @Result(property ="es_eod_quantity",column = "es_eod_quantity" ),
            @Result(property ="es_ep_stock" ,column = "es_ep_stock"),
            @Result(property ="es_ep_id",column = "es_ep_id" ),
            @Result(property ="es_EU_USER_ID",column = "es_eu_user_id" ),
            @Result(property ="ea_valid",column = "es_valid" )
    })
    eb_shop selectShop(@Param("es_eu_user_id")String es_eu_user_id,@Param("pid") int pid);

    @Update("update  EASYBUY_SHOP set es_eod_quantity = es_eod_quantity+#{count} where es_id=#{es_id}")
    int updateShop(@Param("es_id") int es_id,@Param("count") int count);
}
