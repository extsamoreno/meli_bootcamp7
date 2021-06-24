SELECT ep.title, ac.first_name, ac.last_name
FROM episodes ep
JOIN actor_episode ae ON ep.id = ae.episode_id
JOIN actors ac ON ac.id = ae.actor_id