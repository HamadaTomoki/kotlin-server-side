APP_ROOT=$(shell pwd)
MK_FILE=$(APP_ROOT)/Makefile
DC_FILE=$(APP_ROOT)/docker-compose.yml


# docker-compose
up:
	@docker-compose -f $(DC_FILE) up -d
down:
	@docker-compose -f $(DC_FILE) down
ps:
	@docker-compose -f $(DC_FILE) ps
exec:
	@docker-compose -f $(DC_FILE) exec db bash

# linux-commands

chmod:
	chmod -R 775 .

rm:
	@rm -rf $(APP_ROOT)/db/data/*
