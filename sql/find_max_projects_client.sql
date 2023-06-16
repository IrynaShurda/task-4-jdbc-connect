SELECT c.NAME, count(pw.PROJECT_ID) AS PROJECT_COUNT
FROM client c
       JOIN project p ON c.ID = p.CLIENT_ID
       JOIN project_worker pw ON p.ID = pw.PROJECT_ID
GROUP BY (c.NAME)
HAVING count(pw.PROJECT_ID) IN (SELECT MAX(PROJECT_COUNT)
                                FROM client c2
                                       JOIN project p2 ON c2.ID = p2.CLIENT_ID
                                       JOIN project_worker w ON p2.ID = w.PROJECT_ID

                                GROUP BY (c2.NAME)
  );