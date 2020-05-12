package com.hr.dao;

import com.hr.entity.EASYBUY_PRODUCT;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 17:05
 **/
@Repository
public interface EASYBUY_PRODUCTDao {
    @Select("select * from EASYBUY_PRODUCT")
    ArrayList<EASYBUY_PRODUCT> selectAll();

   @Select("select * from EASYBUY_PRODUCT where EP_NAME like #{name}")
    ArrayList<EASYBUY_PRODUCT> selectAllByName(String name);//

     @Select("select * from EASYBUY_PRODUCT where EP_ID=#{id}")
    EASYBUY_PRODUCT selectById(int id);

    @Select("select * from EASYBUY_PRODUCT where EPC_ID=#{fid}")
    ArrayList<EASYBUY_PRODUCT> selectAllByFid(int fid);

    @Select("select * from EASYBUY_PRODUCT where EPC_CHILD_ID=#{cid}")
    ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cid);

    @Insert("insert into EASYBUY_PRODUCT values(null,#{EP_NAME},#{EP_DESCRIPTION},#{EP_PRICE},#{EP_STOCK},#{EPC_ID},#{EPC_CHILD_ID},#{EP_FILE_NAME})")
    int insert(EASYBUY_PRODUCT p);

    @Update("update EASYBUY_PRODUCT set EP_NAME=#{EP_NAME}, EP_DESCRIPTION=#{EP_DESCRIPTION},EP_PRICE=#{EP_PRICE},EP_STOCK=#{EP_STOCK},EPC_ID=#{EPC_ID},EPC_CHILD_ID=#{EPC_CHILD_ID},EP_FILE_NAME=#{EP_FILE_NAME} where EP_ID=#{EP_ID}")
    int update(EASYBUY_PRODUCT p);

    @Update("update EASYBUY_PRODUCT set EP_NAME=#{EP_NAME}, EP_DESCRIPTION=#{EP_DESCRIPTION},EP_PRICE=#{EP_PRICE},EP_STOCK=#{EP_STOCK},EPC_ID=#{EPC_ID},EPC_CHILD_ID=#{EPC_CHILD_ID} where EP_ID=#{EP_ID}")
    int update2(EASYBUY_PRODUCT p);

    @Delete("delete from EASYBUY_PRODUCT where EP_ID=#{id}")
    int del(int id);

    @Select("select count(*) from EASYBUY_PRODUCT")
    int totalPage();

    @Select("select count(*) from EASYBUY_PRODUCT where EPC_ID=#{fid}")
    int totalPageByFid( int fid);

    @Select("select count(*) from EASYBUY_PRODUCT where EPC_CHILD_ID=#{cid}")
    int totalPageByCid(int cid);

    @Select("select count(*) from EASYBUY_PRODUCT where EP_NAME like #{name}")
    int totalPageByName(String name);

    @Select("select * from EASYBUY_PRODUCT order by EP_ID desc limit #{cpage},#{count}")
    ArrayList<EASYBUY_PRODUCT> selectAll2(@Param("cpage") int cpage, @Param("count") int count);

    @Select("select * from EASYBUY_PRODUCT where EPC_ID = #{fid} order by EP_ID desc limit #{cpage},#{count}")
    ArrayList<EASYBUY_PRODUCT> selectAllByFid2(@Param("cpage")int cpage, @Param("count")int count,@Param("fid") int fid);

    @Select("select * from EASYBUY_PRODUCT where EPC_CHILD_ID = #{cid} order by EP_ID desc limit #{cpage},#{count}")
    ArrayList<EASYBUY_PRODUCT> selectAllByCid2(@Param("cpage")int cpage, @Param("count")int count, @Param("cid") int cid);

    @Select("<script>"
            +"select * from EASYBUY_PRODUCT where EP_ID in"
            +"<foreach collection='ids' item='id'  open='(' separator=',' close=')'>"
            +"#{id}"
            +"</foreach>"
            +"</script>")
    ArrayList<EASYBUY_PRODUCT> selectById2( @Param("ids") ArrayList<Integer> ids);

    @Select("select * from EASYBUY_PRODUCT order by EP_PRICE asc limit 0,9")
    ArrayList<EASYBUY_PRODUCT> selectAllByT();

    @Select("select * from ( select tab1.* from  (  select * from easybuy_product a,  (select ep_id eod_ep_id,sum(EOD_QUANTITY) buysum from EASYBUY_ORDER_DETAIL  group by EP_id order by sum(EOD_QUANTITY) desc) b  where a.ep_id=b.eod_ep_id order by buysum desc  ) tab1) tab2 limit 0,8")
    ArrayList<EASYBUY_PRODUCT> selectAllByHot();


}