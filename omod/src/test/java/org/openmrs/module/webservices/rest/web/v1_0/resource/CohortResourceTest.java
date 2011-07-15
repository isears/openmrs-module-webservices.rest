/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource;

import org.openmrs.module.webservices.rest.web.v1_0.resource.CohortResource;
import org.junit.Before;
import org.openmrs.Cohort;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class CohortResourceTest extends BaseDelegatingResourceTest<CohortResource, Cohort> {
	
	@Before
	public void before() throws Exception {
		executeDataSet(ResourceTestConstants.RESOURCE_TEST_DATASET);
	}
	
	@Override
	public Cohort newObject() {
		return Context.getCohortService().getCohortByUuid(getUuidProperty());
	}
	
	@Override
	public void validateRefRepresentation() throws Exception {
	}
	
	@Override
	public void validateDefaultRepresentation() throws Exception {
		assertPropEquals("name", getObject().getName());
		assertPropEquals("description", getObject().getDescription());
		assertPropEquals("voided", getObject().getVoided());
		assertPropPresent("memberIds");
	}
	
	@Override
	public void validateFullRepresentation() throws Exception {
		assertPropEquals("name", getObject().getName());
		assertPropEquals("description", getObject().getDescription());
		assertPropEquals("voided", getObject().getVoided());
		assertPropPresent("memberIds");
		assertPropPresent("auditInfo");
	}
	
	@Override
	public String getDisplayProperty() {
		return "B13 deficit";
	}
	
	@Override
	public String getUuidProperty() {
		return ResourceTestConstants.COHORT_UUID;
	}
	
}
