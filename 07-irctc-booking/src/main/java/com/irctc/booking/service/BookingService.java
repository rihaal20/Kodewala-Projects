package com.irctc.booking.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.booking.entity.BookingEntity;
import com.irctc.booking.repository.BookingRepository;
import com.irctc.booking.request.BookingRequest;
import com.irctc.booking.response.BookingResponse;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	public BookingResponse doBooking(BookingRequest request)
	{
		BookingEntity bookingEntity=new BookingEntity();
		bookingEntity.setFromStation(request.getFrom());
		bookingEntity.setToStation(request.getTo());
		bookingEntity.setJourneyDate(request.getDate());
		bookingEntity.setTravelClass(request.getTravelClass());
		bookingEntity.setPassengerName(request.getPassengerName());
		bookingEntity.setAge(request.getAge());
		bookingEntity.setGender(request.getGender());
	    bookingEntity.setPnrNumber(generatePnr());
		
		BookingEntity response =bookingRepository.save(bookingEntity);
		
		BookingResponse bookingResponse= new BookingResponse();
		bookingResponse.setBookingId(bookingEntity.getBookingId());
		bookingResponse.setPnrNumber(response.getPnrNumber());
		bookingResponse.setBookingStatus("CONFIRMED");
		bookingResponse.setJourneyDate(bookingEntity.getJourneyDate());
		bookingResponse.setCoach("B4");
		bookingResponse.setBerthNumber("23");
		bookingResponse.setMessage("Ticket Booked Successfully !!");
		
		
		return bookingResponse;
	}	
		public static String generatePnr()
		{
			Random random = new Random();
			long pnr = 1000000000L + (long) (random.nextDouble() * 9000000000L);
			return String.valueOf(pnr);
		
	}
		public BookingResponse checkPnrStatus(String pnrNumber)
		{
			BookingEntity bookingEntity=bookingRepository.findByPnrNumber(pnrNumber);
			BookingResponse response=new BookingResponse();
			
			response.setBookingId(bookingEntity.getBookingId());
			response.setPnrNumber(bookingEntity.getPnrNumber());
			response.setJourneyDate(bookingEntity.getJourneyDate());
			response.setBookingStatus("CONFIRMED");
			response.setCoach("B4");
			response.setBerthNumber("23");
			response.setMessage("Ticket Status Fetched Successfully");

		    return response;
		
			
		}
		
}
