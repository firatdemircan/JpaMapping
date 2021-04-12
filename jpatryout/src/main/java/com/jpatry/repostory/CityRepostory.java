package com.jpatry.repostory;

import com.jpatry.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepostory extends JpaRepository<City,Integer> {

    @Query("Select new City(c.id,c.cityName) from City  c")
    List<City> finAllW();

}
