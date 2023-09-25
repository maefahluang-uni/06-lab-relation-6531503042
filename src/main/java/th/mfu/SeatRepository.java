package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Seat;

public interface SeatRepository extends CrudRepository<Seat,Long> {
    public Seat findByConcertId(Long concertId);

    public void deleteByConcertId(Long concertId);
}
