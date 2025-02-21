package in.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sandeep.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

}
