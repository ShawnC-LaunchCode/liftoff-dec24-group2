package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    @Query("SELECT al FROM Album al JOIN FETCH al.artist ar ORDER BY ar.name ASC, al.name ASC")
    List<Album> findAllOrderByArtistNameAlbumName();

    List<Album> findAllByOrderByNameAsc();
}
