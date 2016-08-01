package com.msm.test.utensils;

import com.msm.test.enums.Color;
import com.msm.test.enums.PeelerType;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PeelerFactoryTest {

	@Test
	public void peeler_AppleColorRED_ReturnSteelPeeler() {
		
		Peeler peeler = PeelerFactory.getPeeler(Color.RED);
		assertThat(peeler.getPeelerType(), equalTo(PeelerType.STEEL));
	}
	
	@Test
	public void peeler_AppleColorRED_ReturnValyrianPeeler() {
		
		Peeler peeler = PeelerFactory.getPeeler(Color.BLUE);
		assertThat(peeler.getPeelerType(), equalTo(PeelerType.VALYRIAN_STEEL));
	}

}