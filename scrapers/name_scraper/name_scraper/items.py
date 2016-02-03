# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

from scrapy import Item,Field


class NameScraperItem(Item):
    first_name = Field()
    last_name = Field()
    surname = Field()
