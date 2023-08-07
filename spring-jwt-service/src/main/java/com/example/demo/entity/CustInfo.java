package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author MayilaiMuthu
 * @since 08-Aug-2023
 *
 */
@Entity
@Table(name = "CUST_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private short custId;
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
	@NonNull
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime custCrDt;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime custLastLoginDate;

}
