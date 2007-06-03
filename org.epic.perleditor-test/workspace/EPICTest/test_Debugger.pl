#!/usr/bin/perl

use strict;
use warnings;

use Cwd;

require 'test_Debugger2.pl';

my $x = 123;
my $str = 'string';
my $hash = { first => $x, second => $str };

foo($hash);

sub foo
{
	my $bar = shift;
	$bar->{third} = $bar;
	print "one\n";
	print "two\n";
	print "three\n";
	
	my $path = getcwd().'/test_Debugger2.pl';
	require $path;
}