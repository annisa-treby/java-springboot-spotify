package com.enigma.sepotifay.specification;

import com.enigma.sepotifay.entity.Artist;
import com.enigma.sepotifay.entity.Song;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;

public class ArtistSpecification {

    public static Specification<Artist> findAll(Artist artist){

        return new Specification<Artist>() {
            @Override
            public Predicate toPredicate(Root<Artist> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();
                Join<Artist, Song> artistSongJoin = root.join("songList");
                if(artist != null){
                    if(!StringUtils.isEmpty(artist.getName())){
                        final Predicate artistNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+artist.getName().toLowerCase()+"%");
                        predicates.add(artistNamePredicate);
                    }
                    if(!StringUtils.isEmpty(artist.getBiography())){
                        final Predicate artistOriginPlace = criteriaBuilder.like(criteriaBuilder.lower(root.get("originPlace")), "%"+artist.getBiography().toLowerCase()+"%");
                        predicates.add(artistOriginPlace);
                    }
                    if(!StringUtils.isEmpty(artist.getType())){
                        final Predicate artistTypePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("type")), "%"+artist.getType().toLowerCase()+"%");
                        predicates.add(artistTypePredicate);
                    }
                    if(!StringUtils.isEmpty(artist.getTitle())){
                        final Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(artistSongJoin.get("title")), "%"+artist.getTitle().toLowerCase()+"%");
                        predicates.add(predicate);
                        }
                }
                criteriaQuery.distinct(true);
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}
