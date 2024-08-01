package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
