package com.tw.imageaudit.sor.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public interface ApprovalRepo extends JpaRepository<Approval, String> {
}
