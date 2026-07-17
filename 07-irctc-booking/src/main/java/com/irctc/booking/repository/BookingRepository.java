package com.irctc.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.booking.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	BookingEntity findByPnrNumber(String pnrNumber);
	
}
