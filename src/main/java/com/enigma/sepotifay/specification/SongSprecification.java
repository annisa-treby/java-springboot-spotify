package com.enigma.sepotifay.specification;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;

public class SongSprecification {

    public static Specification<Song> findAll(Song song){
        return new Specification<Song>() {
            @Override
            public Predicate toPredicate(Root<Song> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Song, Artist> songArtistJoin = root.join("artist");
                final Collection<Predicate> predicates = new ArrayList<>();
                if(song != null){
                    if(!StringUtils.isEmpty(song.getTitle())){

                        final Predicate songTitlePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%"+song.getTitle().toLowerCase()+"%");
                        predicates.add(songTitlePredicate);
                    }
                    if(!StringUtils.isEmpty(song.getArtis())){
                        final Predicate artistTitlePredicate = criteriaBuilder.like(criteriaBuilder.lower(songArtistJoin.get("name")), "%"+song.getArtis().toLowerCase()+"%");
                        predicates.add(artistTitlePredicate);
                    }
                }
                criteriaQuery.distinct(true);
                Predicate[] predicates1 = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicates1));
            }
        };
    }
}
