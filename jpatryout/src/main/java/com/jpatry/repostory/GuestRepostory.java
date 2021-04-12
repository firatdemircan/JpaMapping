package com.jpatry.repostory;

import com.jpatry.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepostory extends JpaRepository<Guest,Integer> {
}
