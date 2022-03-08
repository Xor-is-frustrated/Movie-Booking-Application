package com.personal.project.theatre.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "assure_channel_listing", uniqueConstraints = @UniqueConstraint(columnNames = { "channel_id",
		"channel_sku_id" }))
public class ChannelListingPojo extends AbstractPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "channel_sku_id", nullable = false)
	private String channelSkuId;


	@Column(name = "client_id", nullable = false)
	private Long clientId;


	@Column(name = "global_sku_id", nullable = false)
	private Long globalSkuId;


	@Column(name = "channel_id", nullable = false)
	private Long channelId;



}
