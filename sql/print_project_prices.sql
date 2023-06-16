SELECT concat('Project ', p.ID) as NAME, ROUND(SUM(w.SALARY * DATEDIFF(MONTH, p.START_DATE, p.FINISH_DATE))) as PRISE
FROM project p
       JOIN project_worker pw ON p.ID = pw.PROJECT_ID
       JOIN worker w on pw.WORKER_ID = w.ID
GROUP BY (p.ID)
ORDER BY (PRISE) DESC;