package com.personal.project.theatre.dao;

import com.personal.project.theatre.pojo.TheatrePojo;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class TheatreDao extends AbstractDao{

    private static String selectById = "select p from ChannelListingPojo p where id=:id";
    private static String selectAll = "select p from ChannelListingPojo p order by p.id";
    private static String selectByChannelName = "select p from ChannelListingPojo p where p.channelId=:id";
    private static String selectByChannelSkuIdAndChannelId = "select p from ChannelListingPojo p where p" +
            ".channelSkuId=:channelSkuId and p.channelId=:channelId";

    @Transactional
    public TheatrePojo insert(TheatrePojo c) {
        em().persist(c);
        return c;
    }

}
