/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package eu.trentorise.smartcampus.services.ou.impl;

import eu.trentorise.smartcampus.services.ou.data.message.Ou.DescriptionRef;
import eu.trentorise.smartcampus.services.ou.data.message.Ou.Location;
import eu.trentorise.smartcampus.services.ou.data.message.Ou.LocationRef;

public class LocationScript {

	public Location createLocation(LocationRef ref, DescriptionRef desc) {
		String description = desc.getDescription();
		if (description != null) {
			description = description.replace("\\\\n", "\n").trim();
			description = description.replace("\\n", "\n").trim();
		}
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
		.setDescription(description)
		.build();
	}
}
