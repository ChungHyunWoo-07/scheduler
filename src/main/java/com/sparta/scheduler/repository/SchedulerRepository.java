package com.sparta.scheduler.repository;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.entity.Scheduler;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//@Repository  //JpaRepository를 넣음으로 @Repository를 빼도 작동함
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {

}

//    private final JdbcTemplate jdbcTemplate;
//
//    public SchedulerRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    // create
//    public Scheduler save(Scheduler scheduler) {
//        // DB 저장
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        String sql = "INSERT INTO schesuler (username, contents) VALUES (?, ?)";
//        jdbcTemplate.update(con -> {
//                    PreparedStatement preparedStatement = con.prepareStatement(sql,
//                            Statement.RETURN_GENERATED_KEYS);
//
//                    preparedStatement.setString(1, scheduler.getUsername());
//                    preparedStatement.setString(2, scheduler.getContents());
//                    return preparedStatement;
//                },
//                keyHolder);
//
//        //DB Insert 후 받아온 키 확인
//        Long id = keyHolder.getKey().longValue();
//        scheduler.setId(id);
//
//        return scheduler;
//    }
//
//    public List<SchedulerResponseDto> findAll() {
//        // DB 조회
//        String sql = "SELECT * FROM scheduler";
//
//        return jdbcTemplate.query(sql, new RowMapper<SchedulerResponseDto>() {
//            @Override
//            public SchedulerResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //SQL 의 결과로 받아온 스케줄러 데이터들을 스케줄러리스폰스디티오 타입으로 변환해줄 메서드
//                Long id = rs.getLong("id");
//                String username = rs.getString("username");
//                String contents = rs.getString("contents");
//                return new SchedulerResponseDto(id, username, contents);
//            }
//        });
//    }
//
//    //uddate
//    public void update(Long id, SchedulerRequestDto requestDto) {
//        String sql = "UPDATE scheduler SET username = ?, contents = ? WHERE id = ?";
//        jdbcTemplate.update(sql, requestDto.getUsername(), requestDto.getContents(), id);
//    }
//
//    //delete
//    public void delete(Long id) {
//        //해당 메모 삭제하기
//        String sql = "DELETE FROM scheduler WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    //findBYId
//    public Scheduler findById(Long id) {
//        //DB 조회
//        String sql = "SELECT FROM scheduler WHERE id = ?";
//
//        return jdbcTemplate.query(sql, resultset -> {
//            if (resultset.next()) {
//                Scheduler scheduler = new Scheduler();
//                scheduler.setUsername(resultset.getString("username"));
//                scheduler.setContents(resultset.getString("contents"));
//                return scheduler;
//            } else {
//                return null;
//            }
//        }, id);
//    }
//
//    @Transactional
//    public Scheduler createScheduler(EntityManager em) {
//        Scheduler scheduler = em.find(Scheduler.class, 1);
//        scheduler.setUsername("Robbert");
//        scheduler.setContents("@Transactional 전파 테스트 중! 2");
//
//        System.out.println("CreateScheduler 메서드 종료");
//        return scheduler;
//    }
//
//}
