# -*- coding: utf-8 -*-
# Generated by Django 1.9.2 on 2016-02-03 03:39
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('polls', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='choice',
            old_name='votest',
            new_name='votes',
        ),
    ]
