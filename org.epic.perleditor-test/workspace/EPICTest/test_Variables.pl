#!/usr/bin/perl

use Data::Dumper;

my $arr = [ { key => 1 }, { key => 2 } ];
my @list = ( { key => 1 }, { key => 2 } );
my @list2 = ( 1, 2, 3 );
my $arr2 = [ 'aa', 'bb', \@list2 ];
my $hash = { key1 => $arr2, key2 => \$arr };
@foo = (1, 2, 3, $hash);
my $foo2 = \@foo;

print "ok\n";