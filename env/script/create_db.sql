DO $$
    DECLARE
        db_name text;
    BEGIN
        FOREACH db_name IN ARRAY ARRAY[
            'job_hunter_auth',
            'job_hunter_comment',
            'job_hunter_company',
            'job_hunter_currency',
            'job_hunter_file',
            'job_hunter_geo',
            'job_hunter_job',
            'job_hunter_notification',
            'job_hunter_user',
            'job_hunter_profiles'
            ]
            LOOP
                IF NOT EXISTS (
                    SELECT FROM pg_database WHERE datname = db_name
                )
                THEN
                    EXECUTE format('CREATE DATABASE %I', db_name);
                END IF;
            END LOOP;
    END
$$;