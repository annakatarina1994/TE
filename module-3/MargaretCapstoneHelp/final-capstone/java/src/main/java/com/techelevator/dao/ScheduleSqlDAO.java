package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Schedule;
@Component
public class ScheduleSqlDAO implements ScheduleDAO {

	private JdbcTemplate template;
	
	public ScheduleSqlDAO (DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	@Override
	public void assignMealTimesInSchedule (List<Schedule> schedules, int[] timeSchedule){
		
		if (schedules.size() == timeSchedule.length) {
			for (int i=0; i < schedules.size(); i++) {
				Schedule schedule = schedules.get(i);
				String[] time = assignTime(timeSchedule[i]);
				schedule.setDayOfWeek(time[0]);
				schedule.setTimeOfDay(time[1]);
				if(getScheduleRow(schedule.getScheduleId()) != null) {
				editSchedule(schedule);
			}else {
				addNewSchedule(schedule);
			}
			}
			}
	}
		
	public Schedule getScheduleRow(int scheduleId) {	
		String viewScheduleRowSql = "SELECT * FROM schedules WHERE schedule_id=?";
		SqlRowSet result = template.queryForRowSet(viewScheduleRowSql, scheduleId);
		return mapResultToSchedule(result);
		
	}
	
	@Override
	public void addNewSchedule(Schedule schedule) {
		String addNewScheduleSql = "INSERT INTO schedules (meal_plan_id, meal_id, day_of_the_week, time_of_day)"
				+ " VALUES (?, ?, ?, ?)";
		template.update(addNewScheduleSql, schedule.getMealPlanId(),schedule.getMealId(),
				schedule.getDayOfWeek(),schedule.getTimeOfDay());
		

	}

	@Override
	public void editSchedule(Schedule schedule) {
		String editScheduleSql = "UPDATE schedules SET meal_plan_id=?, meal_id=?, day_of_the_week=?, time_of_day=? WHERE schedule_id=?";
		template.update(editScheduleSql, schedule.getMealPlanId(),schedule.getMealId(),
				schedule.getDayOfWeek(),schedule.getTimeOfDay(), schedule.getScheduleId());

	}

	@Override
	public List<Schedule> viewScheduleForMealPlan(int mealPlanId) {
		String viewMealPlanScheduleSql = "SELECT * FROM schedules WHERE meal_plan_id=?";
		SqlRowSet results = template.queryForRowSet(viewMealPlanScheduleSql, mealPlanId);
		List<Schedule> schedule = new ArrayList<>();
		while (results.next()) {
			schedule.add(mapResultToSchedule(results));
			
		}
		
		return schedule;
	}

	@Override
	public void deleteMealFromSchedule(int scheduleId, int mealId) {
		String deleteMealFromScheduleSql = "DELETE * from schedules WHERE schedule_id=? AND WHERE meal_id=?";
		template.update(deleteMealFromScheduleSql, scheduleId, mealId);

	}
	
	private Schedule mapResultToSchedule (SqlRowSet result) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(result.getInt("schedule_id"));
		schedule.setMealPlanId(result.getInt("meal_plan_id"));
		schedule.setMealId(result.getInt("meal_id"));
		schedule.setDayOfWeek(result.getString("day_of_the_week"));
		schedule.setTimeOfDay(result.getString("time_of_day"));
		return schedule;
	}
	private String[] assignTime (int time){
		String day = "";
		String timeOfDay = "";
		String [] assign = {day,timeOfDay};
		if (time == 0) {
			day = "Monday";
			timeOfDay = "Breakfast";
		}else if (time ==1) {
			day = "Monday";
			timeOfDay = "Lunch";
		}else if (time == 2) {
			day = "Monday";
			timeOfDay = "Dinner";
		}
		if (time == 3) {
			day = "Tuesday";
			timeOfDay = "Breakfast";
		}else if (time ==4) {
			day = "Tuesday";
			timeOfDay = "Lunch";
		}else if (time == 5) {
			day = "Tuesday";
			timeOfDay = "Dinner";
		}if (time == 6) {
			day = "Wednesday";
			timeOfDay = "Breakfast";
		}else if (time ==7) {
			day = "Wednesday";
			timeOfDay = "Lunch";
		}else if (time == 8) {
			day = "Wednesday";
			timeOfDay = "Dinner";
		}if (time == 9) {
			day = "Thursday";
			timeOfDay = "Breakfast";
		}else if (time ==10) {
			day = "Thursday";
			timeOfDay = "Lunch";
		}else if (time == 11) {
			day = "Thursday";
			timeOfDay = "Dinner";
		}if (time == 12) {
			day = "Friday";
			timeOfDay = "Breakfast";
		}else if (time ==13) {
			day = "Friday";
			timeOfDay = "Lunch";
		}else if (time == 14) {
			day = "Friday";
			timeOfDay = "Dinner";
		}if (time == 15) {
			day = "Saturday";
			timeOfDay = "Breakfast";
		}else if (time ==16) {
			day = "Saturday";
			timeOfDay = "Lunch";
		}else if (time == 17) {
			day = "Saturday";
			timeOfDay = "Dinner";
		}if (time == 18) {
			day = "Sunday";
			timeOfDay = "Breakfast";
		}else if (time ==19) {
			day = "Sunday";
			timeOfDay = "Lunch";
		}else if (time == 20) {
			day = "Sunday";
			timeOfDay = "Dinner";
		}
		return assign;
		
	}

}
