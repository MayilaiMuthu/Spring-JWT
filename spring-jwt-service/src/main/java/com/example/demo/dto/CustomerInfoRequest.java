package com.example.demo.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author MayilaiMuthu
 * @since 08-Aug-2023
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoRequest {
	
	@NonNull
	@Size(min = 1, max = 25, message = "Need Valid Customer Name(Charaters must be 1-25)")
	private String custName;
	@NonNull
	@Size(min = 4, max = 12, message = "Need Valid Customer Password(Charaters must be 4-12)")
	private String custPassword;
	@Size(min = 7, max = 15, message = "Need Valid Customer Mobile No(Charaters must be 7-15)")
	private long custMobileNo;
	@Size(min = 10, max = 35, message = "Need Valid Customer Email Id(Charaters must be 10-35)")
	private String custEmailId;

}
