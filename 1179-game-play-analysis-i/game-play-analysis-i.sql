select c.player_id, min(c.event_date) as first_login from Activity as c group by c.player_id
