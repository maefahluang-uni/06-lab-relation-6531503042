package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Seat;

public interface SeatRepository extends CrudRepository<Seat,Long> {
    void deleteByConcertId(Long concertId);
}
