package eu.trentorise.smartcampus.services.ou.impl;

import eu.trentorise.smartcampus.services.ou.data.message.Ou.DescriptionRef;
import eu.trentorise.smartcampus.services.ou.data.message.Ou.Location;
import eu.trentorise.smartcampus.services.ou.data.message.Ou.LocationRef;

public class LocationScript {

	public Location createLocation(LocationRef ref, DescriptionRef desc) {
		return Location.newBuilder()
		.setAddress(ref.getAddress())
		.setDetailUrl(ref.getDetailUrl())
		.setId("http://www.operauni.tn.it"+ref.getDetailUrl())
		.setImgUrl(desc.getImgUrl())
		.setLabel(ref.getLabel())
		.setLocalId(ref.getLocalId())
		.setName(ref.getName())
		.setLat(ref.getLat())
		.setLng(ref.getLng())
		.setDescription(desc.getDescription())
		.build();
	}
}
